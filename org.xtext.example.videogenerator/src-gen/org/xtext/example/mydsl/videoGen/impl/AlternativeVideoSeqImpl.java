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

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Alternative Video Seq</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.AlternativeVideoSeqImpl#getVideoid <em>Videoid</em>}</li>
 *   <li>{@link org.xtext.example.mydsl.videoGen.impl.AlternativeVideoSeqImpl#getVideodescs <em>Videodescs</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AlternativeVideoSeqImpl extends VideoSeqImpl implements AlternativeVideoSeq
{
  /**
   * The default value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideoid()
   * @generated
   * @ordered
   */
  protected static final String VIDEOID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVideoid() <em>Videoid</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideoid()
   * @generated
   * @ordered
   */
  protected String videoid = VIDEOID_EDEFAULT;

  /**
   * The cached value of the '{@link #getVideodescs() <em>Videodescs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVideodescs()
   * @generated
   * @ordered
   */
  protected EList<VideoDescription> videodescs;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlternativeVideoSeqImpl()
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
    return VideoGenPackage.Literals.ALTERNATIVE_VIDEO_SEQ;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getVideoid()
  {
    return videoid;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVideoid(String newVideoid)
  {
    String oldVideoid = videoid;
    videoid = newVideoid;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEOID, oldVideoid, videoid));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VideoDescription> getVideodescs()
  {
    if (videodescs == null)
    {
      videodescs = new EObjectContainmentEList<VideoDescription>(VideoDescription.class, this, VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEODESCS);
    }
    return videodescs;
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
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEODESCS:
        return ((InternalEList<?>)getVideodescs()).basicRemove(otherEnd, msgs);
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
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEOID:
        return getVideoid();
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEODESCS:
        return getVideodescs();
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
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEOID:
        setVideoid((String)newValue);
        return;
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEODESCS:
        getVideodescs().clear();
        getVideodescs().addAll((Collection<? extends VideoDescription>)newValue);
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
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEOID:
        setVideoid(VIDEOID_EDEFAULT);
        return;
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEODESCS:
        getVideodescs().clear();
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
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEOID:
        return VIDEOID_EDEFAULT == null ? videoid != null : !VIDEOID_EDEFAULT.equals(videoid);
      case VideoGenPackage.ALTERNATIVE_VIDEO_SEQ__VIDEODESCS:
        return videodescs != null && !videodescs.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (videoid: ");
    result.append(videoid);
    result.append(')');
    return result.toString();
  }

} //AlternativeVideoSeqImpl
