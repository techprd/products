module.exports = {
    // Change build paths to make them Maven compatible
    // see https://cli.vuejs.org/config/
    outputDir: '../target/classes/public',
    assetsDir: 'static',
    devServer: {
        historyApiFallback: true,
        proxy: {
            '/api': {
                logLevel: 'debug', // or 'debug'
                target: 'http://localhost:8080',
                changeOrigin: true,
                ws: true,
            },
        }
    },
    filenameHashing: false,
    productionSourceMap: false,
    chainWebpack: config => {
        if (config.plugins.has('extract-css')) {
            const extractCSSPlugin = config.plugin('extract-css');
            extractCSSPlugin && extractCSSPlugin.tap(() => [{
                filename: 'static/css/[name].css',
                chunkFilename: 'static/css/[name].css'
            }])
        }
    },
    configureWebpack: {
        output: {
            filename: 'static/js/[name].js',
            chunkFilename: 'static/js/[name].js'
        }
    }
};

