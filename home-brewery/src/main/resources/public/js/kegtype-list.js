Vue.use(vueMoment);

const app = new Vue({
  el: '#wrapper',
  data : { 
        kegtypes: null
  },
  mounted () {
    axios
      .get('/kegtype/all')
      .then(response => {
        this.kegtypes = response.data;
          $(document).ready(function() {
          $('#dataTable').DataTable();
        });
      });
    
  }
});
