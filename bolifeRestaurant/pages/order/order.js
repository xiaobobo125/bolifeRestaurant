// pages/order/order.js
var app = getApp()
Page({

  /**
   * 页面的初始数据
   */
  data: {
    foodlist: [],
    overlist: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function() {
    wx.request({
      url: app.globalData.serveraddr + '/order/getOrders',
      data: {
        cusid: app.globalData.cusid
      },
      success: res => {
        console.log(res);
        this.setData({
          overlist: res.data.overOrder
        })
        console.log(this.data.overlist)
        var foodlist = []
        var orderlist = []
        for (let i = 0; i < res.data.order.length; i++) {
          var order = {
            orderid: '',
            orderPrice: 0,
            foods: []
          }
          order.orderid = res.data.order[i].orderId
          order.orderPrice = res.data.order[i].orderTotalPrice
          order.orderTime = res.data.order[i].orderTime
          order.orderNum = res.data.order[i].orderNum
          order.orderState = res.data.order[i].orderState
          order.orderSort = res.data.order[i].orderSort
          for (let k = 0; k < res.data.orderDetailAll.length; k++) {
            for (let j = 0; j < res.data.orderDetailAll[k].length; j++) {
              if (order.orderid == res.data.orderDetailAll[k][j].orderId) {
                console.log(res.data.orderDetailAll[k][j]);
                order.foods.push(res.data.orderDetailAll[k][j].gname + '*' + res.data.orderDetailAll[k][j].gcount)
              }
            }
          }
          foodlist.push(order)
        }
        for (let i = 0; i < foodlist.length; i++) {
          if (foodlist[i].orderState == 1) {
            orderlist.push(foodlist[i])
          }
        }
        this.setData({
          foodlist: orderlist
        })
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },
  agin: function() {
    wx.redirectTo({
      url: '../menu/menu',
    })
  }
})