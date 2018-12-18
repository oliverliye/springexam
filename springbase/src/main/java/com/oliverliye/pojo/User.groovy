package com.oliverliye.pojo

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class User {

    long id
    @Value('oliver')
    String userName
    String note

}
