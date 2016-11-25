/**
 */
package org.xtext.example.mydsl.videoGen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.videoGen.VideoGenInformation;
import org.xtext.example.mydsl.videoGen.VideoGenPackage;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Video Generator Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoGeneratorModelImpl#getInformation <em>Information</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.VideoGeneratorModelImpl#getVideoseqs <em>Videoseqs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VideoGeneratorModelImpl extends MinimalEObjectImpl.Container implements VideoGeneratorModel
{
  /**
   * The cached value of the '{@link #getInformation() <em>Information</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInformation()
   * @generated
   * @ordered
   */
  protected VideoGenInformation information;

  /**
   * The cached value of the '{@link #getVideoseqs() <em>Videoseqs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideoseqs()
   * @generated
   * @ordered
   */
  protected EList<VideoSeq> videoseqs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VideoGeneratorModelImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return VideoGenPackage.Literals.VIDEO_GENERATOR_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VideoGenInformation getInformation()
  {
    return information;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetInformation(VideoGenInformation newInformation, NotificationChain msgs)
  {
    VideoGenInformation oldInformation = information;
    information = newInformation;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION, oldInformation, newInformation);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInformation(VideoGenInformation newInformation)
  {
    if (newInformation != information)
    {
      NotificationChain msgs = null;
      if (information != null)
        msgs = ((InternalEObject)information).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION, null, msgs);
      if (newInformation != null)
        msgs = ((InternalEObject)newInformation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION, null, msgs);
      msgs = basicSetInformation(newInformation, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION, newInformation, newInformation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VideoSeq> getVideoseqs()
  {
    if (videoseqs == null)
    {
      videoseqs = new EObjectContainmentEList<VideoSeq>(VideoSeq.class, this, VideoGenPackage.VIDEO_GENERATOR_MODEL__VIDEOSEQS);
    }
    return videoseqs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION:
        return basicSetInformation(null, msgs);
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__VIDEOSEQS:
        return ((InternalEList<?>)getVideoseqs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION:
        return getInformation();
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__VIDEOSEQS:
        return getVideoseqs();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION:
        setInformation((VideoGenInformation)newValue);
        return;
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__VIDEOSEQS:
        getVideoseqs().clear();
        getVideoseqs().addAll((Collection<? extends VideoSeq>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION:
        setInformation((VideoGenInformation)null);
        return;
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__VIDEOSEQS:
        getVideoseqs().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__INFORMATION:
        return information != null;
      case VideoGenPackage.VIDEO_GENERATOR_MODEL__VIDEOSEQS:
        return videoseqs != null && !videoseqs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //VideoGeneratorModelImpl
