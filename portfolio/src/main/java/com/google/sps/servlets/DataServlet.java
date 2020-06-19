// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.lang.String;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


//The example below is for step 3.  Since these are all in one file, and I can't have multiple servlets, 
//I just commented out the servlet "/name" from step 3 so I could make "/receive-email" from step 4

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
// @WebServlet("/name")
// public class DataServlet extends HttpServlet {

// ArrayList<String> numList = new ArrayList<>();

//   @Override
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//     numList.add("1");
//     numList.add("2");
//     numList.add("3");
//     response.setContentType("text/html;");
//     response.getWriter().println(convertToJsonUsingGson(numList));
//   }

//   private String convertToJsonUsingGson(ArrayList<String> numList) {
//     Gson gson = new Gson();
//     String json = gson.toJson(numList);
//     return json;
//   }


// }

//steps 4 and 5
// @WebServlet("/receive-email")
// public class DataServlet extends HttpServlet {

//     ArrayList<String> emails = new ArrayList<>();

//     @Override
//     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//         // Get the input from the form.
//         String email = getEmail(request);
//         emails.add(email); //arraylist

//         String emailAddress = request.getParameter("emailAddress");

//         Entity emailEntity = new Entity("emailAddress");
//         emailEntity.setProperty("email", emailAddress);

//         DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
//         datastore.put(emailEntity);

//         response.sendRedirect("/index.html");

//         // Redirect back to the HTML page.
//         response.sendRedirect("/index.html");

 
//     }

//     /** Returns the user's email */
//     private String getEmail(HttpServletRequest request) {
//         // Get the input from the form.
//         String userEmail = request.getParameter("user-email");
//         return userEmail;
//     }

// }

@WebServlet("/login-status")
public class DataServlet extends HttpServlet { //class
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        UserService userService = UserServiceFactory.getUserService();
            response.setContentType("text/html");
        if (userService.isUserLoggedIn()) { //function
            response.getWriter().println("<p> Logged in </p>");
            // Get the input from the form.
            String text = getParameter(request, "text-input", ""); //this contains the user's email we got from the html form tag
            //^we unhid the comments section
            String urlToRedirectToAfterUserLogsOut = "/login-status";
            String logoutUrl = userService.createLogoutURL(urlToRedirectToAfterUserLogsOut);
        } else {
            response.getWriter().println("<p> Not logged in </p>");
            String urlToRedirectToAfterUserLogsIn = "/";
            String loginUrl = userService.createLoginURL(urlToRedirectToAfterUserLogsIn);
            response.getWriter().println("<p>Login <a href=\"" + loginUrl + "\">here</a>.</p>");
            // String loginInfo = request.getParameter("login-status");
            // String id = userService.getCurrentUser().getUserId();//has the user log in
        }
    }

    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
}
//     @Override
//     public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//         if !(userService.isUserLoggedIn()) { //checks if the user isn't logged in
//             String userEmail = userService.getCurrentUser().getEmail();
//         } else {
//             // Get the input from the form.
//             String text = getParameter(request, "text-input", ""); //this contains the user's email we got from the html form tag
//             //^this right here is a comment
//         }
    
// }


    
    
