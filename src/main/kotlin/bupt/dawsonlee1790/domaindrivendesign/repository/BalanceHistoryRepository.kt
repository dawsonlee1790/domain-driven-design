package bupt.dawsonlee1790.domaindrivendesign.repository

import bupt.dawsonlee1790.domaindrivendesign.entity.BalanceHistory
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface BalanceHistoryRepository {

    @Insert("insert into balance_history(balance, comment, ref_user_id) values(#{balance}, #{comment}, #{refUserId})")
    fun insert(balanceHistory: BalanceHistory)

    @Select("select * from balance_history where ref_user_id=#{userId}")
    @Results(
        Result(property = "id", column = "id"),
        Result(property = "balance", column = "balance"),
        Result(property = "comment", column = "comment"),
        Result(property = "refUserId", column = "ref_user_id")
    )
    fun findAllByUserId(userId: Int): List<BalanceHistory>

}