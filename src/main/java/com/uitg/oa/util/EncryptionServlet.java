package com.uitg.oa.util;

import java.io.IOException;

import java.security.KeyPair;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


/**

 * Servlet implementation class EncryptionServlet

 */

public class EncryptionServlet extends HttpServlet {

       private static final long serialVersionUID = 1L;


       public EncryptionServlet() {

       }

       protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

               int KEY_SIZE = 1024;
               if (request.getParameter("generateKeypair") != null) {
                      JCryption jCryptionUtil = new JCryption();
                      KeyPair keys = null;
                      //if (request.getSession().getAttribute("keys") == null) { // 这里注释掉 否则第二次请求会 500
                             keys = jCryptionUtil.generateKeypair(KEY_SIZE);
                             request.getSession().setAttribute("keys", keys);
                      //}
                      StringBuffer output = new StringBuffer();
                      String e = JCryption.getPublicKeyExponent(keys);
                      String n = JCryption.getPublicKeyModulus(keys);
                      String md = String.valueOf(JCryption.getMaxDigits(KEY_SIZE));
                      output.append("{\"e\":\"");
                      output.append(e);
                      output.append("\",\"n\":\"");
                      output.append(n);
                      output.append("\",\"maxdigits\":\"");
                      output.append(md);
                      output.append("\"}");
                      output.toString();
                      response.getOutputStream().print(output.toString().replaceAll("\r", "").replaceAll("\n", "").trim());
               } else {
                      response.getOutputStream().print(String.valueOf(false));

               }
      }
}
