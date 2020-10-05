Vue.component('kegtype-select-component',{
  props: ['value'],
  data () {
    return {
      kegTypes : null
    }
  },
  template:`
    <select class="form-control"
      @change="change">
      <option 
        v-for="kegType in kegTypes" 
        :value="kegType.id"
        :selected="selectedOption(kegType)">
          {{kegType.name}}
      </option>
    </select>
  `,
  mounted () {
  	axios
      .get('/kegtype/all')
      .then(response => (this.kegTypes = response.data))
  },
  methods : {
    selectedOption(option) {
      if (this.value) {
        return option.id === this.value.id;
      }
      return false;
    },
    update: function () {
      this.$emit('input', 
        {
          id: this.$refs.kegType.value.id,
          name: this.$refs.kegType.value.name
        })
    },
    change(e) {
      const selectedCode = e.target.value;
      const option = this.kegTypes.find((option) => {
        return selectedCode === option.id;
      });
      this.$emit("input", option);
    }

  }
})
