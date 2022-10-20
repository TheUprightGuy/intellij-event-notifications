package nz.co.jbelton.eventnotifications.views

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManager
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.util.ui.FormBuilder
import org.jetbrains.annotations.NotNull
import javax.swing.JComponent
import javax.swing.JPanel


class AppSettingsView {
    private var myMainPanel: JPanel
    private val myUserPath = TextFieldWithBrowseButton()
    private val myIdeaUserStatus = JBCheckBox("Do you use IntelliJ IDEA? ")
    init {
        val p: Project = ProjectManager.getInstance().openProjects[0]
        val fileChooser = FileChooserDescriptorFactory.createSingleFileDescriptor()
        myUserPath.addBrowseFolderListener("", "", p, fileChooser)
        myMainPanel = FormBuilder.createFormBuilder()
            .addLabeledComponent(JBLabel("Enter user name: "), myUserPath, 1, false)
            .addComponent(myIdeaUserStatus, 1)
            .addComponent(JPanel(), 0)
            .panel
    }

    fun getPanel(): JPanel {
        return myMainPanel
    }

    fun getPreferredFocusedComponent(): JComponent {
        return myUserPath
    }

    @NotNull
    fun getUserPath(): String {
        return myUserPath.text
    }

    fun setUserPath(@NotNull newText: String) {
        myUserPath.text = newText
    }

    fun getIdeaUserStatus(): Boolean {
        return myIdeaUserStatus.isSelected
    }

    fun setIdeaUserStatus(newStatus: Boolean) {
        myIdeaUserStatus.isSelected = newStatus
    }
}