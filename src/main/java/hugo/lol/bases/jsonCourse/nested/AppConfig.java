package hugo.lol.bases.jsonCourse.nested;

public class AppConfig {
    private String appName;
    private String version;
    private Settings settings;

    public AppConfig(String appName, Settings settings, String version) {
        this.appName = appName;
        this.settings = settings;
        this.version = version;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    static class Settings {
        private String theme;
        private boolean notifications;
        private String language;

        public Settings(String language, boolean notifications, String theme) {
            this.language = language;
            this.notifications = notifications;
            this.theme = theme;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public boolean isNotifications() {
            return notifications;
        }

        public void setNotifications(boolean notifications) {
            this.notifications = notifications;
        }

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }
    }

}
