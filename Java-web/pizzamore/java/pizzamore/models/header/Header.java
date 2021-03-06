package pizzamore.models.header;


import pizzamore.models.cookie.Cookie;

import java.util.ArrayList;
import java.util.List;

public class Header {

    private String type;
    private String location;
    private List<Cookie> cookies;

    public Header() {
        this.type = "Content-type: text/html;";
        this.cookies = new ArrayList<>();
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void addCookie(Cookie cookie) {
        this.cookies.add(cookie);
    }

    public void printHeader() {
        System.out.println(this.type);
        if (!this.cookies.isEmpty()) {
            String cookies = "";
            for (Cookie cookie : this.cookies) {
                cookies += cookie.getCookieValue();
            }

            System.out.println("Set-Cookie: " + cookies);
        }

        if (this.location != null) {
            System.out.println("Location: " + this.location);
        }

        System.out.println();
    }
}
