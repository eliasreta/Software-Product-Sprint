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


@WebServlet("/login-status")
public class DataServlet extends HttpServlet { //class
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        UserService userService = UserServiceFactory.getUserService();
            response.setContentType("text/html;");
        if (userService.isUserLoggedIn()) { //function
            response.getWriter().println("Logged in");
            String userEmail = userService.getCurrentUser().getEmail(); //get's user's email address
            //^we unhid the comments section
            String urlToRedirectToAfterUserLogsOut = "/login-status";
            String logoutUrl = userService.createLogoutURL(urlToRedirectToAfterUserLogsOut);
            response.getWriter().println("<p>Hello " + userEmail + "!</p>");
            response.getWriter().println("<p>To navigate to the comments page, click <a href= \"UserInput.html\">here</a></p>");
            response.getWriter().println("<p>Logout <a href=\"" + logoutUrl + "\">here</a>.</p>");
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

  @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException { //use post when storing info from the user
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        UserService userService = UserServiceFactory.getUserService();
        if (!(userService.isUserLoggedIn())) { //checks if the user isn't logged in
            String userEmail = userService.getCurrentUser().getEmail();
        } else {
            // Get the input from the form.
            String text = getParameter(request, "text-input", ""); //this contains the user's email we got from the html form tag
            //^this right here is a comment
        }
        response.getWriter().println("HI IM PAULL");
    
    }
}
    


    
    
