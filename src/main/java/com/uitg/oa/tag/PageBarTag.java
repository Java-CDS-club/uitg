package com.uitg.oa.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Description Here
 *
 * @author Michael
 */
public class PageBarTag extends TagSupport {

    private int page;

    private int total;

    private String uri;

    @Override
    public int doStartTag() throws JspException {
        JspWriter out = this.pageContext.getOut();

        String contextPath = pageContext.getServletContext().getContextPath();

        String url = contextPath + getUri() + "?page=";

        try {
            out.println("<ul class=\"pagination\">");
            out.println("<li");
            if (page == 1) {
                out.println(" class=\"disabled\"><a onclick=\"return false\"");
            } else {
                out.println("><a");
            }
            out.println(" href=\"" + url + "1\">&laquo;</a></li>");

            int offset = 0;
            int first = page - 2;
            if (first < 1) {
                offset = 1 - first;
                first = 1;
            }

            int last = page + offset + 2;
            if (last > total) {
                last = total;
                if (first - 2 < 1) {
                    first = 1;
                }
                first = first - 2;
                first = first < 1 ? 1 : first;
            }

            String u;
            for (int i = first; i <= last; i++) {
                u = url + i;
                if (i == page) {
                    out.println("<li class=\"active\"><a onclick=\"return false\">" + i + "</a></li>");
                } else {
                    out.println("<li><a href=\"" + u + "\">" + i + "</a></li>");
                }
            }

            out.println("<li");
            if (page == total) {
                out.println(" class=\"disabled\"><a onclick=\"return false\"");
            } else {
                out.println("><a ");
            }
            out.println(" href=\"" + url + total + "\">&raquo;</a></li>");
        } catch (IOException e) {
            throw new JspException(e.getMessage(), e);
        }
        return super.doStartTag();
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = this.pageContext.getOut();

        try {
            out.println("</ul>");
        } catch (IOException e) {
            throw new JspException(e.getMessage(), e);
        }

        return super.doEndTag();
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
