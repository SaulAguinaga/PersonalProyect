import axios from "axios";
import { ref } from "vue";

export default class CategoryService {
    category;
    #url = "http://localhost:8080/api/categories"

    constructor() {
        this.category = ref();
    }

    getCategory() {
        return this.category.value
    }

    async submitCategory(categoryData) {
        try {
            axios({
                method: "POST",
                url: this.#url + "/add",
                data: categoryData,
                withCredentials: true,

            }).then(response => {
                console.log(response)
            });

        } catch (error) {
            console.log(error);

        }
    }

    async fetchAllCategories(){
        try {
            await axios({
                method: "GET",
                url: this.#url,
                withCredentials: true,
            }).then(response =>{
                this.category.value=response.data
                console.log(response.data) 
            });
        
        } catch (error) {
            console.log(error)
        }
    }
    async fetchOneCategory(id){
        try {
            await axios({
                method: "GET",
                url: this.#url + "/" + id,
                withCredentials: true,
            }).then(response =>{
                this.category.value=response.data
                console.log(response.data) 
            });
        
        } catch (error) {
            console.log(error)
        }
    }
}