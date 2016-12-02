package com.uitg.oa.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.i18n.AbstractLocaleResolver;
import org.springframework.web.util.CookieGenerator;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Description Here
 *
 * @author Michael
 */
public class SessionCookieLocalResolver extends AbstractLocaleResolver {

    public static final String LOCALE_SESSION_ATTRIBUTE_NAME = SessionCookieLocalResolver.class.getName() + ".LOCALE";
    public static final String DEFAULT_COOKIE_NAME = SessionCookieLocalResolver.class.getName() + ".LOCALE";

    private CookieGenerator cookieGenerator;

    public SessionCookieLocalResolver() {
        cookieGenerator = new CookieGenerator();
        cookieGenerator.setCookieName(DEFAULT_COOKIE_NAME);
    }


    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // if locale != null, then update locale to session and cookie
        if (locale != null) {
            WebUtils.setSessionAttribute(request, LOCALE_SESSION_ATTRIBUTE_NAME, locale);
            cookieGenerator.addCookie(response, locale.toString());
        }
        // else, set session to default locale, also reset cookie to default locale
        else {
            WebUtils.setSessionAttribute(request, LOCALE_SESSION_ATTRIBUTE_NAME, determineDefaultLocale(request));
            cookieGenerator.removeCookie(response);
            cookieGenerator.addCookie(response, determineDefaultLocale(request).toString());
        }
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // Check session for pre-parsed or preset locale.
        Locale locale = (Locale) WebUtils.getSessionAttribute(request, LOCALE_SESSION_ATTRIBUTE_NAME);
        if (locale != null) {
            return locale;
        }

        // Retrieve and parse cookie value.
        Cookie cookie = WebUtils.getCookie(request, cookieGenerator.getCookieName());
        if (cookie != null) {
            locale = StringUtils.parseLocaleString(cookie.getValue());
        } else {
            locale = request.getLocale();
            if(locale == null) {
                locale = determineDefaultLocale(request);
            }
        }

        // if locale is parsed from cookie, then save it to session too.
        WebUtils.setSessionAttribute(request, LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        return locale;
    }

    /**
     * Determine the default locale for the given request,
     * Called if no locale session attribute has been found.
     * <p>The default implementation returns the specified default locale,
     * if any, else falls back to the request's accept-header locale.
     *
     * @param request the request to resolve the locale for
     * @return the default locale (never {@code null})
     * @see #setDefaultLocale
     * @see javax.servlet.http.HttpServletRequest#getLocale()
     */
    protected Locale determineDefaultLocale(HttpServletRequest request) {
        Locale defaultLocale = getDefaultLocale();
        if (defaultLocale == null) {
            defaultLocale = request.getLocale();
        }
        return defaultLocale;
    }

}
