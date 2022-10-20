package nz.co.jbelton.eventnotifications.services

import com.intellij.openapi.options.Configurable
import nz.co.jbelton.eventnotifications.data.AppSettingsState
import nz.co.jbelton.eventnotifications.views.AppSettingsView
import javax.swing.JComponent


class AppSettingsConfigurable: Configurable {

    private var eventNotificationsSettingsView: AppSettingsView? = null

    override fun createComponent(): JComponent {
        eventNotificationsSettingsView = AppSettingsView()
        return eventNotificationsSettingsView!!.getPanel()
    }

    override fun isModified(): Boolean {
        val settings = AppSettingsState.getInstance()
        var modified: Boolean = eventNotificationsSettingsView!!.getUserPath() != settings.userPath
        modified = modified or (eventNotificationsSettingsView!!.getIdeaUserStatus() != settings.ideaStatus)
        return modified
    }

    override fun apply() {
        val settings = AppSettingsState.getInstance()
        settings.userPath = eventNotificationsSettingsView!!.getUserPath()
        settings.ideaStatus = eventNotificationsSettingsView!!.getIdeaUserStatus()
    }

    override fun reset() {
        val settings = AppSettingsState.getInstance()
        eventNotificationsSettingsView!!.setUserPath(settings.userPath)
        eventNotificationsSettingsView!!.setIdeaUserStatus(settings.ideaStatus)
    }

    override fun disposeUIResources() {
        eventNotificationsSettingsView = null
    }
    override fun getDisplayName(): String {
        return "Event Notifications";
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return eventNotificationsSettingsView!!.getPreferredFocusedComponent()
    }
}