import axios from "axios";
import { validationMixin } from "vuelidate";
import { required, minLength, between } from "vuelidate/lib/validators";

export default {
  data() {
    return {
      errors: [],
      modalHeader : 'Add Contact',
      vContact: {
        firstname: "",
        city: "",
        email: "",
        number: ""
      },
      search:'',
      content: [],
      allContent: [],
      contact: {
        firstname: "",
        number: "",
        email: "",
        city: "",
        id: ""
      }
    };
  },
  watch: {
    search(){
      console.log(this.search);
      this.content = this.allContent.filter(cont => 
        cont.firstname.toLowerCase().includes(this.search) ||
        cont.number.includes(this.search)
      );
    }
  },
  mixins: [validationMixin],
  validations: {
    contact: {
      firstname: {
        required,
        minLength: minLength(4)
      },
      
      number: {
        required
      }
    
    }
  },

  methods: {
    getContacts() {
      axios.get("http://localhost:5005/contacts/contact/"+localStorage.getItem('response')).then(response => {
        this.content = response.data;
        this.allContent = this.content;
      });
    },

    submit() {
      
      if (this.$v.$invalid) {
       console.log("error");
       
      } else {
        if (this.contact.id === "") {
          console.log(this.contact);
          
          axios
            .post("http://localhost:5005/contacts/contact/"+localStorage.getItem('response'), this.contact)
            .then(data => {
              this.content.push(data.data);
              
             
            });
        } else {
          axios
            .put(
              "http://localhost:5005/contacts/contact/"+localStorage.getItem('response')+"/" + this.contact.id,
              this.contact
            )
            .then(co => {
              let i = this.content.findIndex(x => x.id === co.data.id);
              this.getContacts();
            });
        }
      }
    },
    addData(){

      this.modalHeader = 'Add Contact';
      this.contact.id = '';
      this.contact.firstname = '';
      this.contact.number = '';
      this.contact.city = '';
    },
    editdata(id) {
      let c = this.content.find(x => x.id === id);
      console.log(c);
      this.modalHeader = 'Edit Contact';
      this.contact.id = c.id;
      this.contact.firstname = c.firstname;
      this.contact.number = c.number;
      this.contact.city = c.city;
    },

    deletedata(id) {
      axios
        .delete("http://localhost:5005/contacts/contact/"+localStorage.getItem('response')+"/"+ id)
        .then(() => this.getContacts());
    },

    viewContact: function (data) {
      this.vContact.firstname = data.firstname;
      this.vContact.number = data.number;
      this.vContact.email = data.email;
      this.vContact.city = data.city;
    },

    Logout(){
      localStorage.clear();
      this.$router.push("/login");

    },



    convertCamelCaseToNormalCase: function (name) {
      const nameLength = name.length;
      let newName = name.charAt(0).toUpperCase();
      for (let i = 1; i < nameLength; i++) {
        if (this.isUpperCase(name.charAt(i))) newName += " " + name.charAt(i);
        else newName += name.charAt(i);
      }
      return newName;
    },

    isUpperCase: function (aCharacter) {
      return aCharacter >= "A" && aCharacter <= "Z";
    }
  },
  created() {
    this.getContacts();
  }
};


