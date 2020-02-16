<template>
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
</template>
<script>
export default {
    data(){
        return {
            
        }
    }
}
</script>