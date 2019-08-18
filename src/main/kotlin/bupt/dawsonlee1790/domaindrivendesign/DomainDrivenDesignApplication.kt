package bupt.dawsonlee1790.domaindrivendesign

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@MapperScan("bupt.dawsonlee1790.domaindrivendesign.repository")
class DomainDrivenDesignApplication

fun main(args: Array<String>) {
    runApplication<DomainDrivenDesignApplication>(*args)
}
