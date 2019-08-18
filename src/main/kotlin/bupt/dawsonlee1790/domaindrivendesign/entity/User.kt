package bupt.dawsonlee1790.domaindrivendesign.entity

import bupt.dawsonlee1790.domaindrivendesign.component.SpringContext
import bupt.dawsonlee1790.domaindrivendesign.repository.BalanceHistoryRepository
import com.fasterxml.jackson.annotation.JsonIgnore

class User(
    val id: Int,
    val name: String?,
    val age: Int?
) {
    val balanceHistoryList: List<BalanceHistory>
        get() = balanceHistoryRepository.findAllByUserId(id)

    @JsonIgnore
    val balanceHistoryRepository = SpringContext.getBean(BalanceHistoryRepository::class.java)

    /**
     * 领工资
     */
    fun pickUpMyWage(wage: Double) {
        balanceHistoryRepository.insert(
            BalanceHistory(
                id = 0,
                balance = wage,
                comment = "领工资啦",
                refUserId = id
            )
        )
    }

}
