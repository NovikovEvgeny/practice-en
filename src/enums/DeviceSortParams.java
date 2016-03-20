package enums;


import entities.Device;

import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by Evgeny on 19.03.2016.
 */
public class DeviceSortParams {
    public static HashMap<String, DeviceComparator> deviceSortMap =
            new HashMap<String, DeviceComparator>();

    public static void init() {
        deviceSortMap.put("id", DeviceComparator.ID_SORT);
        deviceSortMap.put("model", DeviceComparator.MODEL_SORT );
        deviceSortMap.put("type", DeviceComparator.TYPE_SORT);
        deviceSortMap.put("color", DeviceComparator.COLOR_SORT);
        deviceSortMap.put("date", DeviceComparator.DATE_SORT);
    }

    public enum DeviceComparator implements Comparator<Device> {
        ID_SORT {
            public int compare(Device c1, Device c2) {
                return Integer.valueOf(c1.getID()).compareTo(c2.getID());
            }
        },
        MODEL_SORT {
            public int compare(Device c1, Device c2) {
                return c1.getModel().compareToIgnoreCase(c2.getModel());
            }
        },
        TYPE_SORT {
            public int compare(Device c1, Device c2) {
                return c1.getType().compareToIgnoreCase(c2.getType());
            }
        },
        COLOR_SORT {
            public int compare(Device c1, Device c2) {
                return c1.getColor().compareToIgnoreCase(c2.getColor());
            }
        },
        DATE_SORT {
            public int compare(Device c1, Device c2) {
                return c1.getDate().compareTo(c2.getDate());
            }
        };

        public static Comparator<Device> getComparator(final Comparator<Device> comp) {
            return new Comparator<Device>() {
                public int compare(Device o1, Device o2) {
                    return comp.compare(o1, o2);
                }
            };
        }

    }
}
