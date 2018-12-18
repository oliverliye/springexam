package com.oliverliye.pojo

import org.springframework.beans.factory.annotation.Value
import org.springframework.beans.factory.config.ConfigurableBeanFactory
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

@Component('userscan')
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class UserScan {

    @Value('2')
    long id
    @Value('oliver2')
    String userName
    @Value('note2')
    String note

}
