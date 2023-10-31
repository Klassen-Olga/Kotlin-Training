package classes

class User(var firstName:String?="", val lastName:String=""){

    // is called after constructor
    // in the order they are defined
    init {
        //firstName=null
    }
    init {
        //firstName="second name"
    }

    // read property only
    val fullName="$lastName $firstName"

    // overwriting getter
    // $field is value inside fullNameWithPrefix
    val fullNameWithPrefix="$lastName $firstName"
        get() = "Fullname: $field"

    // overwriting setter
    var fullNameWithPostfix="$lastName $firstName"
        set(name){ field="$name huha" }

    // static method
    companion object{
        fun getOne():User{
            return User()
        }
        fun getMultiple():List<User>{
            var users= mutableListOf<User>()
            for (i in 0..5){
                users.add(User(i.toString()))
            }
            return users
        }

    }

    override fun toString(): String {
        return "User(firstName='$firstName', lastName='$lastName')"
    }
}