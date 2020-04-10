/**
 * Precompiled [code-check.gradle.kts][Code_check_gradle] script plugin.
 *
 * @see Code_check_gradle
 */
class CodeCheckPlugin : org.gradle.api.Plugin<org.gradle.api.Project> {
    override fun apply(target: org.gradle.api.Project) {
        try {
            Class
                .forName("Code_check_gradle")
                .getDeclaredConstructor(org.gradle.api.Project::class.java)
                .newInstance(target)
        } catch (e: java.lang.reflect.InvocationTargetException) {
            throw e.targetException
        }
    }
}
