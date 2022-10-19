package nz.co.jbelton.eventnotifications.listeners

import com.intellij.execution.ExecutionListener
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import nz.co.jbelton.eventnotifications.controllers.SoundController

class RunsListener() : ExecutionListener {

    var soundController: SoundController = SoundController()

    override fun processStarted(
        executorId: String,
        env: ExecutionEnvironment,
        handler: ProcessHandler
    ) {
        super.processStarted(executorId, env, handler)
        println("Everything went fine")
        soundController.playAudio("/home/jbelton/Downloads/ding.wav")
    }

    override fun processNotStarted(executorId: String, env: ExecutionEnvironment) {
        super.processNotStarted(executorId, env)
    }

    override fun processTerminated(
        executorId: String,
        env: ExecutionEnvironment,
        handler: ProcessHandler,
        exitCode: Int
    ) {
        super.processTerminated(executorId, env, handler, exitCode)
        println("Oops")
    }


}