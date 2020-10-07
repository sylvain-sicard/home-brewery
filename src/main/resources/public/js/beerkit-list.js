Vue.use(vueMoment);

const app = new Vue({
  el: '#wrapper',
  data : { 
        beerkits: null,
        filter: 'available'
  },
  mounted () {
    var actionUrl = '/beerkit/all/available';

    var uri = window.location.search.substring(1); 
    var params = new URLSearchParams(uri);
    
    if(params.has('filter') && params.get('filter')=="all"){
      this.filter='all';
      actionUrl = '/beerkit/all';
    }else if(params.has('filter') && params.get('filter')=="brewed"){
      this.filter='brewed';
      actionUrl = '/beerkit/all/brewed';
    }else if(params.has('filter') && params.get('filter')=="available"){
      this.filter='available';
      actionUrl = '/beerkit/all/available';
    }

    axios
      .get(actionUrl)
      .then(response => {
        this.beerkits = response.data;
          $(document).ready(function() {
          $('#dataTable').DataTable();
        });
      });
    
  }
});
