import axios from "axios";
import { validationMixin } from "vuelidate";
import { required, minLength, between } from "vuelidate/lib/validators";

export default {
  name: 'signup',
  components: {},
  props: [],
  data () {
    return {


      signup: {
        email: "",
        password: "",
        id: ""
      }
    }
  },
  
  mixins: [validationMixin],
  validations: {
    signup: {
      email: {
        required
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

    getsignupDetails() {

      if (this.$v.$invalid) {
        console.log("error");
        
       }
       else{
      axios.post("http://localhost:5005/login/signupdetails",{'email':this.signup.email,'password':this.signup.password}).then(response => {
        this.signup = response.data;
        localStorage.setItem('response',response.data);
        this.$router.push("/contacts");
      });}
    }  
  }
}
