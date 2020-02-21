<template>
  <v-layout>
    <v-app-bar
      color="white"
      app
      clipped-left
    >
      <v-app-bar-nav-icon @click="miniVariant = !miniVariant" />

      <v-toolbar-title>개키우는개발자</v-toolbar-title>

      <v-spacer />
      <v-btn
        color="primary"
        to="/signin"
      >
        로그인
      </v-btn>
    </v-app-bar>
    <v-navigation-drawer
      v-model="drawer"
      :mini-variant="miniVariant"
      app
      clipped
    >
      <v-list
        dense
        nav
        class="py-4"
      >
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-layout>
</template>
<script>
export default {
    data(){
        return {
           drawer: true,
            items: [
              { title: 'Dashboard', icon: 'mdi-view-dashboard' },
              { title: 'Photos', icon: 'mdi-image' },
              { title: 'About', icon: 'mdi-help-box' },
            ],
            color: 'primary',
            colors: [
              'primary',
              'blue',
              'success',
              'red',
              'teal',
            ],
            miniVariant: false,
        }
    },
    computed: {
      
    },
    methods:{
     
    }
    
}
</script> 

<style scoped>
  
</style>