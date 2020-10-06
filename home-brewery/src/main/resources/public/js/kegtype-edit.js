Vue.use(vueMoment);

const app = new Vue({

  el: '#wrapper',
  components: {
  	vuejsDatepicker
  },
  data : {
        kegtype : {}
  },
  mounted () {
  	let uri = window.location.search.substring(1); 
    let params = new URLSearchParams(uri);
    
    if(params.has('id')){
      axios
        .get('/kegtype/'+params.get("id"))
        .then(response => {
          this.kegtype = response.data;
        });
      
    }
  },
  methods: {
    save: function () {
        axios
        .post('/kegtype/add', this.kegtype)
        .then(response => {
          this.kegtype = response.data;
          window.location.href='/kegtype-view.html?id='+this.kegtype.id;
        });
  
    },
    remove: function () {
      axios
        .delete('/kegtype/'+this.kegtype.id)
        .then(response => {
          this.kegtype = {};
          window.location.href='/kegtype-list.html';
        });
    },
    handleFileUpload: function (kegtype) {
      var file = this.$refs.icon.files[0];
      var reader = new FileReader();
      reader.addEventListener("load", function () {
        kegtype.icon=reader.result;
      }, false);
      reader.readAsDataURL(file);
    }
  }
});


