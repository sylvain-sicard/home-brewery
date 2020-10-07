Vue.use(vueMoment);

const app = new Vue({
  el: '#wrapper',
  data : { 
        kegs: null,
        filter: 'filled'
  },
  mounted () {
    var actionUrl = '/keg/all/filled';

    var uri = window.location.search.substring(1); 
    var params = new URLSearchParams(uri);
    
    if(params.has('filter') && params.get('filter') == "all"){
      this.filter='all';
      actionUrl = '/keg/all';
    } else if(params.has('filter') && params.get('filter') == "registered"){
      this.filter='registered';
      actionUrl = '/keg/all/registered';
    } else if(params.has('filter') && params.get('filter') == "unregistered"){
      this.filter='unregistered';
      actionUrl = '/keg/all/unregistered';
    } else if(params.has('filter') && params.get('filter') == "filled"){
      this.filter='filled';
      actionUrl = '/keg/all/filled';
    } else if(params.has('filter') && params.get('filter') == "empty"){
      this.filter='empty';
      actionUrl = '/keg/all/empty';
    } 
    axios
      .get(actionUrl)
      .then(response => {
        this.kegs = response.data;
          $(document).ready(function() {
            $('#dataTable').DataTable();
        });
      });
    
  }
});
