package nz.co.jbelton.eventnotifications.data

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.Nullable

@State(
    name = "org.intellij.sdk.settings.AppSettingsState",
    storages = [Storage("EventNotifications.xml")]
)
class AppSettingsState : PersistentStateComponent<AppSettingsState> {
    companion object {
        fun getInstance(): AppSettingsState {
            return ApplicationManager.getApplication().getService(AppSettingsState::class.java)
        }
    }

    var userPath = "John Q. Public"
    var ideaStatus = false

    var paths: Collection<String> = emptySet()

    @Nullable
    override fun getState(): AppSettingsState {
        return this
    }

    override fun loadState(state: AppSettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }
}
