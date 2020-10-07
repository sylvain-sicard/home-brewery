

const app = new Vue({

  el: '#app',
  data : {
        kegs: null
  },
  mounted () {
    axios
      .put('/keg/add-all/42')
      .then(response => {
      	this.kegs = response.data;   	
      });
    
  },
  methods: {
    load: function (q) {
   
      
    }
  }
});


