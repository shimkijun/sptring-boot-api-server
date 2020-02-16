<template>
  <v-app>
    <v-navigation-drawer
      v-model="drawer"
      temporary
      absolute
    >
      <v-list shaped>
        <v-subheader>
          <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
          <nuxt-link to="/" id="logo">
            <img src="~assets/images/logo.png" :alt="images.logo.description" />
          </nuxt-link>
        </v-subheader>
        
        <v-list-tile
          router
          :to="item.to"
          :key="i"
          v-for="(item, i) in items"
          exact
        >
          <v-list-tile-action>
            <v-icon v-html="item.icon"></v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title v-text="item.title"></v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>
    </v-navigation-drawer>
    <v-toolbar fixed app :clipped-left="clipped">
      <v-toolbar-side-icon @click.stop="drawer = !drawer"></v-toolbar-side-icon>
      <nuxt-link to="/" id="logo">
        <img src="~assets/images/logo.png" :alt="images.logo.description" />
      </nuxt-link>
      <v-spacer></v-spacer>
       <v-btn class="mx-2" fab dark small :color="changedIconColor" v-if="user">
        <span>ㄱㅈ</span>
      </v-btn>
      <router-link to="/signin" v-else>
        <div class="my-2">
          <v-btn color="primary">로그인</v-btn>
        </div>
      </router-link>
    </v-toolbar>
    <v-content>
      <v-container>
        <nuxt />
      </v-container>
    </v-content>
  </v-app>
</template>

<script>
  export default {
    data () {
      return {
        user: false,
        clipped: true,
        drawer: false,
        items: [
          { icon: 'apps', title: 'Welcome', to: '/' },
          { icon: 'bubble_chart', title: 'Inspire', to: '/inspire' }
        ],
        images: {
          logo: {
            path: '~assets/images/logo.png',
            description: '사이트 로고'
          }
        }
      }
    },
    computed: {
      changedIconColor () {
        const colors = [
          'success',
          'error',
          'warning',
          'pink',
          'secondary',
          'teal',
          'indigo',
          'cyan',
          'purple'
        ]
        let colorClassIndex = Math.floor(Math.random() * colors.length)
        return colors[colorClassIndex]
      }
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
