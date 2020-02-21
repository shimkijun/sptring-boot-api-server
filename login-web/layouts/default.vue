<template>
  <v-app>
    <Header />
    <nuxt />
  </v-app>
</template>

<script>
import Header from '~/components/defaultHeader.vue'
  export default {
    components: {
      Header
    },
    data () {
      return {
        
      }
    },
    computed: {
     
    },
    methods: {
  
    }
  }
</script>
<style scoped>
  #logo{
    width:100px;
  }
  #logo img{
    width:100%;
    vertical-align: middle;
  }
</style>