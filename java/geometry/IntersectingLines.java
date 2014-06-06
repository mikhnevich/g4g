package geometry;

import java.util.*;

/**
 * Created @ 6/6/2014
 *
 * http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=lineSweep
 * http://apps.topcoder.com/forums/?module=Thread&threadID=684537
 *
 */
public class IntersectingLines {
    enum EventType {
        End,
        Vertical,
        Start
    }

    public static class Event implements Comparable<Event> {
        public EventType eventType;
        int x;
        int lineIndex;

        public Event(EventType eventType, int x, int lineIndex) {
            this.eventType = eventType;
            this.x = x;
            this.lineIndex = lineIndex;
        }

        @Override
        public int compareTo(Event o) {
            return (x == o.x ? eventType.compareTo(o.eventType) : (int) Math.signum(x - o.x));
        }
    }

    public List<Point> intersections(Line[] lines) {
        int size = lines.length;
        List<Event> events = new ArrayList<>();
        List<Point> answers = new ArrayList<>();

        SortedSet<Integer> active = new TreeSet<>();

        for (int i = 0; i < size; i++) {
            if (lines[i].y1 != lines[i].y2) {
                events.add(new Event(EventType.Vertical, lines[i].x1, i));
            } else if (lines[i].x1 != lines[i].x2) {
                events.add(new Event(EventType.Start, lines[i].x1, i));
                events.add(new Event(EventType.End, lines[i].x2, i));
            }
        }

        Collections.sort(events);

        for (Event e : events) {
            Line line = lines[e.lineIndex];
            switch (e.eventType) {
                case Start:
                    active.add(line.y1);
                    break;

                case End:
                    active.remove(line.y1);
                    break;

                case Vertical:
                    SortedSet<Integer> candidates = active.subSet(line.y1, line.y2);
                    for (Integer c : candidates) {
                        answers.add(new Point(line.x1, c));
                    }
            }
        }
        return answers;

    }
}
