<template>
  <div>
    <v-navigation-drawer
      :clipped="clipped"
      :mini-variant="mini"
      app
      overflow
    >
      <v-list
        shaped
        class="mt-3"
      >
        <v-spacer />
        <v-list-item-group
          v-model="selectedIndex"
          color="primary"
          role="listbox"
        >
          <v-list-item
            v-for="(category, i) in categories"
            :key="i"
            role="listitem"
            :to="category.link"
          >
            <v-list-item-icon>
              <v-icon v-text="category.icon" />
            </v-list-item-icon>
            <v-list-item-content>
              <v-list-item-title v-text="category.title" />
            </v-list-item-content>
          </v-list-item>
        </v-list-item-group>
      </v-list>
    </v-navigation-drawer>
    <v-app-bar
      :clipped-left="clipped"
      app
    >
      <v-app-bar-nav-icon
        @click.stop="mini = !mini"
      />
      <v-toolbar-title>개키우는개발자</v-toolbar-title>

      <v-spacer />
    
      <v-switch
        v-model="$vuetify.theme.dark"
        primary
        label="Dark"
        dense
        hide-details
      />
    </v-app-bar>
  </div>
</template>

<script>
  export default {
    data(){
      return {
        clipped: true,
        mini: false,
        selectedIndex: 0,
        categories: [
          { title: 'HOME', icon: 'mdi-home', link:'/' },
          { title: '로그인', icon: 'mdi-account' , link:'/signin'},
        ],
      }
    },
  }
</script>

<style >
  a{
     text-decoration: none;
  }
</style>