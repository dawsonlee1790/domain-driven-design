package bupt.dawsonlee1790.domaindrivendesign.repository

import bupt.dawsonlee1790.domaindrivendesign.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Repository
interface UserRepository {


    @Insert("insert into user(name, age) values (#{name}, #{age})")
    fun insert(user: User)

    @Select("select * from user where id=#{id}")
    @Results(
        Result(property = "id", column = "id"),
        Result(property = "name", column = "name"),
        Result(property = "age", column = "age")
    )
    fun findById(id: Int): User?

}