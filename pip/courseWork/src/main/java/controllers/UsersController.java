package controllers;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;

import ejb.UsersAccess;
import entity.Users;
import org.json.JSONException;
import org.json.JSONObject;

@WebServlet(name = "users", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {

  @EJB
  private UsersAccess users;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    BufferedReader reader = request.getReader();
    StringBuilder builder = new StringBuilder();
    String line;

    String action;
    String password;
    String login;
    String email;

    try {
      while ((line = reader.readLine()) != null) {
        builder.append(line);
      }

      JSONObject jsonObject = new JSONObject(builder.toString());

      action = jsonObject.getString("action");
      login = jsonObject.getString("login");
      password = jsonObject.getString("password");
      email = jsonObject.getString("email");
    } catch (JSONException e) {
      throw new IOException("Error parsing JSON request string");
    }

    if (action.isEmpty()) {
      throw new ServletException("Action is null");
    } else if (action.equals("reg")) {
      tryAddUser(login, password, email);
      addRegistration(login, password, request);
    } else if (action.equals("check")) {
      checkUser(login, password);
      addRegistration(login, password, request);
    } else if (action.equals("exit")) {
      removeRegistration(request);
    } else {
      throw new ServletException("Unknown action");
    }
  }

  private void tryAddUser(String login, String password, String email) throws ServletException {
    if (login.isEmpty() || email.isEmpty() || password.isEmpty() || password.matches(".*\\s+") ||
        login.matches(".*\\s+") || email.matches(".*\\s+") ||
        !email.matches(".*@(mail.ru|bk.ru|list.ru|inbox.ru|gmail.ru)$")) {
      throw new ServletException("Incorrect input");
    }

    users.addNewUser(login, email, password);
  }

  private void checkUser(String login, String password) throws ServletException {
    users.checkUser(login, password);
  }

  private void addRegistration(String login, String password, HttpServletRequest request) {
    HttpSession session = request.getSession();

    Users user = new Users();
    user.setLogin(login);
    user.setPassword(password);

    session.setAttribute("user", user);
  }

  private void removeRegistration(HttpServletRequest request) {
    HttpSession session = request.getSession();

    Users user = new Users();
    user.setLogin("");
    user.setPassword("");

    session.setAttribute("user", user);
  }
}