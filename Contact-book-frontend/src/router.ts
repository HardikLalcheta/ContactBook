import Vue from "vue";
import Router from "vue-router";


Vue.use(Router);

const router = new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {

      path: "/",
      redirect:"/login"
    
    },
    {
      path:"/login",
      name: "login",
      component: () =>
      import("./components/login/index.vue")

    },
    {
      path:"/signup",
      name: "signup",
      component: () =>
      import("./components/signup/index.vue")

    },
    {
      path: "/contacts",
      name: "contacts",
      meta: {requiresAuth: true},
      component: () =>
        import("./components/contact-list/index.vue")
    }
  ]
})


router.beforeEach((to, from, next) => {
  
  //  console.log(to);
  console.log(localStorage.getItem('response'));
  
  if(to.matched.some(record => record.meta.requiresAuth)) {
    if (localStorage.getItem('response')) {
      
      return next()
    }
    return next('/login') 
  } else {
    return next() 
  }
});


export default router;