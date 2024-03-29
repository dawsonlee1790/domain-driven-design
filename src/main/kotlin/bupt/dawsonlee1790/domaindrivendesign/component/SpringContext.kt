package bupt.dawsonlee1790.domaindrivendesign.component

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

@Component
class SpringContext : ApplicationContextAware {
    override fun setApplicationContext(applicationContext: ApplicationContext) {
        context = applicationContext
    }

    companion object {
        private var context: ApplicationContext? = null

        fun <T : Any> getBean(beanClass: Class<T>): T {
            return context!!.getBean(beanClass)
        }
    }
}