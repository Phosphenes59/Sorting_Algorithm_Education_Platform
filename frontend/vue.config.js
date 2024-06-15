const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  publicPath: '/',
  transpileDependencies: true,
  devServer: {
    // proxy: {
    //   '/api': {
    //     target: 'http://localhost:8888',
    //     changeOrigin: true,
    //     pathRewrite: {
    //       '^/api': ''  // 移除前缀
    //     }
    //   }
    // },
    port: 8080,
  },
  publicPath: process.env.NODE_ENV === 'production' ? '/' : '/'
})
