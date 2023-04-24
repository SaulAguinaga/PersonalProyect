import axios from "axios";
import { ref } from "vue";

export default class AcademyService {
    academy;
    #url = "http://localhost:8080/api/academies"

    constructor() {
        this.academy = ref();
    }

    getAcademy() {
        return this.academy.value
    }

    async submitAcademy(academyData) {
        try {
            axios({
                method: "POST",
                url: this.#url + "/add",
                data: academyData,
                withCredentials: true,

            }).then(response => {
                console.log(response)
            });

        } catch (error) {
            console.log(error);

        }
    }

    async fetchAllAcademies(){
        try {
            await axios({
                method: "GET",
                url: this.#url,
                withCredentials: true,
            }).then(response =>{
                this.academy.value=response.data
                console.log(response.data) 
            });
        
        } catch (error) {
            console.log(error)
        }
    }
    async fetchOneAcademy(id){
        try {
            await axios({
                method: "GET",
                url: this.#url + "/" + id,
                withCredentials: true,
            }).then(response =>{
                this.academy.value=response.data
                console.log(response.data) 
            });
        
        } catch (error) {
            console.log(error)
        }
    }
}