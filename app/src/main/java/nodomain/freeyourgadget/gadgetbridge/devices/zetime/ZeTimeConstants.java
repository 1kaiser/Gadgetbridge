package nodomain.freeyourgadget.gadgetbridge.devices.zetime;

/**
 * Created by lightforce on 08.06.18.
 */

import java.util.UUID;

public class ZeTimeConstants {
    public static final UUID UUID_WRITE_CHARACTERISTIC = UUID.fromString("00008001-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_ACK_CHARACTERISTIC = UUID.fromString("00008002-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_REPLY_CHARACTERISTIC = UUID.fromString("00008003-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_NOTIFY_CHARACTERISTIC = UUID.fromString("00008004-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_CHARACTERISTIC_8005 = UUID.fromString("00008005-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_CHARACTERISTIC_HEART_RATE = UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_CONFIG_DESCRIPTOR = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_SERVICE_BASE = UUID.fromString("00006006-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_SERVICE_EXTEND = UUID.fromString("00007006-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_SERVICE_HEART_RATE = UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb");

    public static final byte CMD_PREAMBLE = (byte) 0x6f;
    // list all available commands
    public static final byte CMD_RESPOND = (byte) 0x01;
    public static final byte CMD_WATCH_ID = (byte) 0x02;
    public static final byte CMD_DEVICE_VERSION = (byte) 0x03;
    public static final byte CMD_DATE_TIME = (byte) 0x04;
    public static final byte CMD_TIME_SURFACE_SETTINGS = (byte) 0x05;
    public static final byte CMD_SURFACE_DISPLAY_SETTIGNS = (byte) 0x06;
    public static final byte CMD_SCREEN_BRIGHTNESS = (byte) 0x07;
    public static final byte CMD_BATTERY_POWER = (byte) 0x08;
    public static final byte CMD_VOLUME_SETTINGS = (byte) 0x09;
    public static final byte CMD_SHOCK_MODE = (byte) 0x0A;
    public static final byte CMD_LANGUAGE_SETTINGS = (byte) 0x0B;
    public static final byte CMD_UNIT_SETTINGS = (byte) 0x0C;
    public static final byte CMD_FACTORY_RESTORE = (byte) 0x0D;
    public static final byte CMD_ENTER_UPGRADE_MODE = (byte) 0x0E;
    public static final byte CMD_SHOCK_STRENGTH = (byte) 0x10;
    public static final byte CMD_WORK_MODE = (byte) 0x12;
    public static final byte CMD_SCREEN_ON_TIME = (byte) 0x13;
    public static final byte CMD_SNOOZE = (byte) 0x14;
    public static final byte CMD_DO_NOT_DISTURB = (byte) 0x15;
    public static final byte CMD_USER_INFO = (byte) 0x30;
    public static final byte CMD_USAGE_HABITS = (byte) 0x31;
    public static final byte CMD_USER_NAME = (byte) 0x32;
    public static final byte CMD_GOALS = (byte) 0x50;
    public static final byte CMD_AVAIABLE_DATA = (byte) 0x52;
    public static final byte CMD_DELETE_STEP_COUNT = (byte) 0x53;
    public static final byte CMD_GET_STEP_COUNT = (byte) 0x54;
    public static final byte CMD_DELETE_SLEEP_DATA = (byte) 0x55;
    public static final byte CMD_GET_SLEEP_DATA = (byte) 0x56;
    public static final byte CMD_DELETE_HEARTRATE_DATA = (byte) 0x5A;
    public static final byte CMD_GET_HEARTRATE_DATA = (byte) 0x5B;
    public static final byte CMD_AUTO_HEARTRATE = (byte) 0x5C;
    public static final byte CMD_HEARTRATE_ALARM_LIMITS = (byte) 0x5D;
    public static final byte CMD_INACTIVITY_ALERT = (byte) 0x5E;
    public static final byte CMD_CALORIES_TYPE = (byte) 0x60;
    public static final byte CMD_GET_HEARTRATE_EXDATA = (byte) 0x61;
    // here are the action commands
    public static final byte CMD_REQUEST = (byte) 0x70;
    public static final byte CMD_REQUEST_RESPOND = (byte) 0x80;
    // further commands
    public static final byte CMD_END = (byte) 0x8f;
    public static final byte CMD_ACK_WRITE = (byte) 0x03;
}
