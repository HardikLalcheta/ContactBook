import axios from "axios";
import { validationMixin } from "vuelidate";
import { required, minLength, between } from "vuelidate/lib/validators";

export default {
  name: 'login',
  components: {},
  props: [],
  data () {
    return {

      login: {
        email: "",
        password: "",
        id: ""
      }
    }
  },

  mixins: [validationMixin],
  validations: {
    login: {
      email: {
        required,
             },
      
      password: {
        required
      }
    
    }
  },
  mounted () {
    if(localStorage.getItem('response') != 'false' && localStorage.getItem('response') != undefined){
      this.$router.push("/contacts");
    }
  },
  methods: {

    
    getLoginDetails() {

      if (this.$v.$invalid) {
        console.log("error");
        
       } else{
      axios.post("http://localhost:5005/login/logindetails",this.login).then(response => {
        this.login = response.data;
        if(response.data!=-1){
          localStorage.setItem('response',response.data);
          this.$router.push("/contacts");
        }        
      });}
    }  
  }


}
