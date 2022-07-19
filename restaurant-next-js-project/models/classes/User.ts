export class User {
    username:string;
    password:string;
    enabled:string;

    constructor(username:string,password:string,enabled:string){
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    get getUsername(){
        return this.username;
    }

    set setUsername(username:string){
        this.username = username;
    }

    get getPassword(){
        return this.password;
    }

    set setPassword(password:string){
        this.password = password;
    }

    get getEnabled(){
        return this.enabled;
    }
    set setEnabled(enabled:string){
        this.enabled = enabled;
    }
}