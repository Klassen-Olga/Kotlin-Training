package classes

class Employee(var id: String,var fullname: String, var teamName: String){
    constructor(id:String, fullname: String): this(id, fullname, "notAssigned")
    //this one calls previous one
    constructor(id:String): this(id, "unknown")


    override fun toString(): String {
        return "Employee(id='$id', fullname='$fullname', teamName='$teamName')"
    }


}