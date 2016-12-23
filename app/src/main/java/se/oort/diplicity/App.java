package se.oort.diplicity;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import se.oort.diplicity.apigen.MultiContainer;
import se.oort.diplicity.apigen.SingleContainer;
import se.oort.diplicity.apigen.User;

public class App extends Application {

    public static String authToken;
    public static String baseURL;
    public static User loggedInUser;
    public static boolean localDevelopmentMode;
    public static String localDevelopmentModeFakeID;
    public static MultiContainer<VariantService.Variant> variants;

    public static String nanosToDuration(long nanos) {
        return minutesToDuration((int) ((nanos / (long) 1000000000) / (long) 60));
    }

    public static String minutesToDuration(int mins) {
        long days = mins / (60 * 24);
        long hours = (mins - (60 * 24 * days)) / 60;
        long minutes = mins - (60 * 24 * days) - (60 * hours);
        List<String> timeLabelList = new ArrayList<String>();
        if (days > 0) {
            timeLabelList.add("" + days + "d");
        }
        if (hours > 0) {
            timeLabelList.add("" + hours + "h");
        }
        if (minutes > 0) {
            timeLabelList.add("" + minutes + "m");
        }
        StringBuilder timeLabel = new StringBuilder();
        for (int i = 0; i < timeLabelList.size(); i++) {
            timeLabel.append(timeLabelList.get(i));
            if (i < timeLabelList.size() - 1) {
                timeLabel.append(", ");
            }
        }
        return timeLabel.toString();
    }

}
