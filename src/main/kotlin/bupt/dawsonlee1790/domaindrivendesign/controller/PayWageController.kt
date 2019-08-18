package bupt.dawsonlee1790.domaindrivendesign.controller

import bupt.dawsonlee1790.domaindrivendesign.entity.User
import bupt.dawsonlee1790.domaindrivendesign.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PayWageController {

    @Autowired
    private lateinit var userRepository: UserRepository

    @PutMapping("/{userId}/{balance}")
    fun payWage(
        @PathVariable("userId") userId: Int,
        @PathVariable("balance") balance: Double
    ) {
        userRepository.findById(userId).also {
            it?.pickUpMyWage(balance)
        }
    }

    @PutMapping
    fun newUser(@RequestBody user: User) {
        userRepository.insert(user)
    }

    @GetMapping("/{userId}")
    fun getUser(@PathVariable("userId") userId: Int): User? {
        return userRepository.findById(userId)
    }
}