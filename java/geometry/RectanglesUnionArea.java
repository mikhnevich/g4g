package geometry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created @ 6/6/2014
 *
 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=lineSweep
 * http://apps.topcoder.com/forums/?module=Thread&threadID=684537
 */
public class RectanglesUnionArea {
    enum EventType {
        LeftEdge,
        RightEdge
    }


    public static class Event implements Comparable<Event> {
        public EventType eventType;
        int x;
        int rectangleIndex;

        public Event(EventType eventType, int x, int rectangleIndex) {
            this.eventType = eventType;
            this.x = x;
            this.rectangleIndex = rectangleIndex;
        }

        @Override
        public int compareTo(Event o) {
            return (x == o.x ? eventType.compareTo(o.eventType) : (int) Math.signum(x - o.x));
        }
    }

    public double area(Rectangle[] rectangles) {
        List<Event> events = new ArrayList<>();
        for (int i = 0; i < rectangles.length; i++) {
            Rectangle r = rectangles[i];
            events.add(new Event(EventType.LeftEdge, r.upperLeft.x, i));
            events.add(new Event(EventType.RightEdge, r.bottomRight.x, i));
        }
        Collections.sort(events);

        for (Event e : events) {

        }
        return 0;
    }
}
