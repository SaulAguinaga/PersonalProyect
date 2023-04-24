import axios from "axios";
import { ref } from "vue";
export { default as GroupService } from '../services/GroupService';


export default class GroupService {
    group;
    #url = "http://localhost:8080/api/groups"

    constructor() {
        this.group = ref();
    }

    getGroup() {
        return this.group.value
    }

    async submitGrpoup(groupData) {
        try {
            axios({
                method: "POST",
                url: this.#url + "/add",
                data: groupData,
                withCredentials: true,

            }).then(response => {
                console.log(response)
            });

        } catch (error) {
            console.log(error);

        }
    }

    async fetchAllGroups(){
        try {
            await axios({
                method: "GET",
                url: this.#url,
                withCredentials: true,
            }).then(response =>{
                this.group.value=response.data
                console.log(response.data) 
            });
        
        } catch (error) {
            console.log(error)
        }
    }
}