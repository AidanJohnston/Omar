package Util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public final class RequestTypeRedux //Yo we're using this one its like 10000000 times better
{
    public static final String  UPDATE,
                                LOGIN;
    // etc.

public static final Collection<String> ALL_PATHS;
    static {
        ALL_PATHS = Collections.unmodifiableCollection(Arrays.asList(
            UPDATE = "update",
            LOGIN = "login"
            // etc.
        ));
    }
}
